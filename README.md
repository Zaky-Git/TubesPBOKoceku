# TubesPBOKoceku

prerequisite :
(Untuk Development) :
1. Java 17
2. Maven (versi yang dipakai 3.9.2, tetapi bisa menggunakan versi lain) sudah terinstall (ketik "mvn --version" tanpa tanda petik 2 pada cmd untuk mengetahui sudah terinstall apa belum),
   jika belum install maven silahkan ikuti tutorial berikut ini https://www.youtube.com/watch?v=km3tLti4TCM&ab_channel=AmitThinks

(Untuk Normal) :
1. Java 17
2. Run XAMPP (MySQL, dan Apache)
3. Buatlah database bernama koceku
4. Di file application.properties pada folder koceku, ubah user = "root" dan password di kosongkan.

Mode Normal :
1. Buka folder koceku
2. di bagian java project (bagian kiri bawah)
3. Klik Debug (Logo gambar segitiga dan serangga) pada bagian koceku

Mode Development : 
1. buka terminal vscode
2. pastikan sekarang berada pada folder koceku, jika belum ketik "cd koceku" tanpa tanda petik
3. run ini pada terminal "mvn spring-boot:run" tanpa petik 2
4. ke terminal (dibagian atas) lalu klik split terminal
5. ketik "cd src" tanpa petik 2 lalu enter
6. ketik "cd main" tanpa petik 2 lalu enter
7. ketik "cd frontend" tanpa petik 2 lalu enter
8. setelah berada pada folder frontend, ketik "npm run watch" tanpa petik 2
9. ke browser lalu ketik localhost:8080/Login
10. ke browser lalu ketik localhost:8080

