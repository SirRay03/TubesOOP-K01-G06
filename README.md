# Sim-Plicity
Sebuah game yang dibuat berbasis GUI (Graphic User Interface) dan semua game dibuat dengan menggunakan bahasa Java dan fungsionalitas game dibuat menyerupaian game The Sims untuk memenuhi tugas besar mata kuliah Pemrograman Berorientasi Objek IF2212. 
***
## Anggota Kelompok
| Nama | NIM | 
| ------| ---- |
| Josua Adriel Sinabutar| 18221065 |
| Willy Frans Farel Sijabat | 18221087 | 
| Hugo Benedicto Tanadi | 18221131 | 
| Rayhan Anugrah Putra | 18221149 | 
| Victoria Angelique | 18221153 | 
***
## Cara melakukan compile

### Step 1
1. Download dan install Java Development Kit (JDK) dari [Oracle JDK download page](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) atau [OpenJDK website](https://adoptopenjdk.net/).
2. Ikuti instruksi instalasi sesuai dengan operating system anda.

### Step 2
Download semua file zip dari github di branch Main 

### Step 3
Tulis command berikut di terminal yang berada di directory file 
javac -cp ".;gui/*;src/*;Items/*" -d . Main.java gui/*.java src/*.java Items/*.java && jar cvfm SimPlicity.jar META-INF/MANIFEST.MF *.class gui/*.class src/*.class Items/*.class

### Step 4 : Run
Double click file simplicity tersebut dan aplikasi berhasil dibuka dan bisa dimainkan

## Happy Playing Sims!
