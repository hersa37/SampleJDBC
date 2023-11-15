# Contoh project untuk mata kuliah PBOL

Berikut contoh project simple yang menggunakan database, untuk ambil data dan memasukkan data.

Terdapat 5 file utama:

- [Main.java](src/main/java/Main.java) adalah file utama yang akan dijalankan
- [Database.java](src/main/java/Database.java) adalah file yang berisi class untuk mengakses database
- [database.db](src/main/resources/database.db) adalah file database yang digunakan
- [User.java](src/main/java/User.java) adalah file yang berisi class untuk menyimpan data user, berfungsi sebagai container data dari database dan main
- [pom.xml](pom.xml) adalah file yang berisi konfigurasi project, seperti library yang digunakan, dan plugin yang digunakan

Database yang digunakan adalah SQLITE3, yang adalah database yang disimpan dalam file ketimbang server. Untuk melihat isi database, buka file [database.db](src/main/resources/database.db) di DBMS masing-masing.