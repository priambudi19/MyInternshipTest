# MyInternshipTest
# Apa saja library Android yang sering atau biasa anda pakai? Jelaskan kegunaannya bagi anda. 
 - Delegate ViewBinding
 agar tidak ribet inisialisasi viewbindind pada activity atau fragment
 - Retrofit
  sebagai rest client, agar android bisa melakukan post/get/put/patch dst ke server
 - LiveData
 Untuk handling ui secara reaktif 
 - Coroutine
untuk mengambil data secara asyncronus
- Room
untuk menyimpan data di localdatabase 
- Android KTX
agar bisa menulis kode versi ekstension kotlin yang mana biasanya itu lebih simple 
- dsb

# Apakah anda menggunakan prinsip clean code atau design pattern untuk    project Android anda? Jelaskan penerapan clean code atau design pattern yang biasa anda  gunakan dan manfaatnya untuk anda

ya, penerapan clean code menggunakan prinsip SOLID dan biasanya menggunakan arsitektur MVVM. Manfaatnya diantaranya:
1.  **Maintainability**  
    Memisahkan berbagai jenis kode dengan bersih, dan membuatnya mudah untuk masuk ke bagian-bagian tertentu tanpa khawatir jika ada perubahan. 
    
2.  **Testability**  
Sangat memungkinkan untuk menerapkan testing seperti Unit Testing pada repository atau viewmodel atau Instrumentation testing
    
4.  **Extensibility**  
  Membuat bagian-bagian kode menjadi reusable(dapat digunakan ulang dan tidak boilerplate)

