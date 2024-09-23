# AndroidArmour

We have include the following 2 Fintech Android app security features in this respository :
- [Passcode & Biometric Authentication](#section-1)  - 
- [Transaction Encryption](#section-2)

# <a name="section-1">
## 1. Passcode & Biometric Authentication :

- To use passcode and biometric authentication import the  [Passcode Library](https://github.com/akashmeruva9/Android_FIntech_Security_library/tree/master/passcode_library) into your porject, example has been given on how to use this in your app :

| Normal | With Passcode | With Passcode and Biometric |
|---------|---------|---------|
| <video src="https://github.com/user-attachments/assets/9e4a4b0f-10eb-4e1c-9755-976aaf029cdb" width="320" controls></video> | <video src="https://github.com/user-attachments/assets/ca21055a-7fc1-4cd7-b424-fddbc39eeb78" width="320" controls></video> | <video src="https://github.com/user-attachments/assets/66d5b879-2d91-49e7-a99c-b495e846868a" width="320" controls></video> |
</a>

# <a name="section-2">

## 2.Transaction Encryption :

### 1. **Ensure HTTPS (TLS) Communication**
   - Ensure all communication happens over HTTPS by default. Android 9 (Pie) and later enforce HTTPS. No specific Kotlin code is needed, just ensure your server has a valid SSL certificate.

### 2. **Encrypt Data Using AES**

```kotlin
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import java.security.KeyStore
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.SecretKey
import javax.crypto.spec.GCMParameterSpec

fun encryptTransactionData(transactionData: String): ByteArray {
    val cipher = Cipher.getInstance("AES/GCM/NoPadding")
    val secretKey = getSecretKey()  // Fetch the secret key from Android Keystore
    cipher.init(Cipher.ENCRYPT_MODE, secretKey)
    
    val iv = cipher.iv // Initialization vector (IV)
    val encryptedData = cipher.doFinal(transactionData.toByteArray()) // Encrypt the transaction data
    return encryptedData
}

// Get the secret key from the Android Keystore
fun getSecretKey(): SecretKey {
    val keyStore = KeyStore.getInstance("AndroidKeyStore")
    keyStore.load(null)

    return keyStore.getKey("transactionKeyAlias", null) as SecretKey
}
```

### 3. **Store Keys Securely in Android Keystore**

```kotlin
fun generateSecretKey() {
    val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore")
    val keyGenParameterSpec = KeyGenParameterSpec.Builder(
        "transactionKeyAlias",
        KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
    ).setBlockModes(KeyProperties.BLOCK_MODE_GCM)
     .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_NONE)
     .build()

    keyGenerator.init(keyGenParameterSpec)
    keyGenerator.generateKey()  // This key will be securely stored in the Keystore
}
```

### Steps Summary:
1. **Store keys securely** in **Android Keystore** using `KeyGenerator`.
2. **Encrypt transaction data** using **AES/GCM** with the secret key fetched from the Keystore.
3. **Use HTTPS** for secure communication.

This ensures secure and encrypted transactions in your Android app.
</a>
