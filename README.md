# Лабораторийн ажил 09 — JaCoCo Code Coverage

**Оюутан:** Оюунсүрэн Мөнхзолбоо  
**Оюутны код:** B210910878  
**Хичээл:** Програм хангамжийн чанар ба тестлэлт

## 1. Зорилго

JaCoCo ашиглан Java програмын Line Coverage болон Branch Coverage хэмжих, тестийн хамрах хүрээг нэмэгдүүлэх, CFG шинжилгээ хийх, давталтын хязгаарын утгууд болон програмын алдааг тестээр илрүүлэх.

## 2. Ашигласан орчин

**Java:**
```text
openjdk version "17.0.20.1" 2026-08-18 LTS
OpenJDK Runtime Environment Microsoft-14940689 (build 17.0.20.1+1-LTS)
OpenJDK 64-Bit Server VM Microsoft-14940689 (build 17.0.20.1+1-LTS, mixed mode, sharing)
```

**Maven:**
```text
Apache Maven 3.9.16 (2bdd9fddda4b155ebf8000e807eb73fd829a51d5)
Maven home: C:\maven\apache-maven-3.9.16
Java version: 17.0.20.1, vendor: Microsoft, runtime: C:\Program Files\Microsoft\jdk-17.0.20.101-hotspot
Default locale: en_US, platform encoding: Cp1252
OS name: "windows 11", version: "10.0", arch: "amd64", family: "windows"
```

**Технологи:** JUnit 5, JaCoCo 0.8.12

## 3. Part A — Эхний хамрах хүрээ

Эхний 4 тестийг ажиллуулж JaCoCo тайлан гаргасан.

- Line Coverage: 15/25 = 60%
- Branch Coverage: 20/41 = 48.78%

Эхний тестүүд нь үндсэн зөв оролтуудыг шалгасан тул зарим үнэлгээний нөхцөл, буруу оролтын шалгалт болон тэтгэлгийн доод түвшний нөхцөлүүд хамрагдаагүй.

## 4. Part B — Хамрах хүрээг нэмэгдүүлэх

Үнэлгээний зааг, буруу оролт, GPA болон тэтгэлгийн нөхцөлүүдийг шалгах нэмэлт тестүүд бичсэн.

- Line Coverage: 25/25 = 100%
- Branch Coverage: 41/41 = 100%
- Missed branches: 0

CFG диаграмм: `cfg.png`

## 5. Part C — Давталтын хязгаарын тест

`gpa()` функцийн давталтыг дараах байдлаар шалгасан.

- 0 элемент: `gpa_zeroElements_throwsException`
- 1 элемент: `gpa_oneElement_returnsFour`
- 2-оос олон элемент: `gpa_multipleElements_returnsTwoPointFive`

100% coverage гарсан ч давталтын бүх хязгаарын утга зөв ажиллаж байгааг заавал батлахгүй. Иймээс хоосон, нэг элементтэй болон олон элементтэй массивыг тусад нь шалгасан.

## 6. Part D — Boundary bug

`letterGrade()` функцэд `score > 60` нөхцөлөөс шалтгаалан 60 оноонд `F` үнэлгээ буцааж байсан.

`letterGrade_boundaryScores` тестээр уг алдааг илрүүлсэн.

- Expected: D
- Actual: F

Нөхцөлийг `score >= 60` болгож зассан.

Эцсийн үр дүн:

- Tests run: 14
- Failures: 0
- Errors: 0
- Line Coverage: 100%
- Branch Coverage: 100%

## 7. Дүгнэлт

JaCoCo ашиглан тестийн хамрах хүрээг хэмжиж, Line болон Branch Coverage-ийг 100%-д хүргэсэн. Гэхдээ 100% Branch Coverage нь програм бүх оролт дээр зөв ажиллана гэсэн баталгаа биш. Учир нь нөхцөлийн хоёр салаа ажилласан ч заагийн утгад логикийн алдаа байж болно. Үүнийг 60 онооны boundary test-ээр илрүүлсэн. Иймээс coverage хэмжилтийг boundary-value болон бусад тестийн аргуудтай хослуулах шаардлагатай.

## 8. Ажиллуулах заавар

```powershell
mvn clean verify
```

JaCoCo HTML тайлан: `target/site/jacoco/index.html`

## 9. Үр дүнгийн файлууд

- `results/mvn-verify-A.txt`
- `results/jacoco-A.csv`
- `results/mvn-verify-B.txt`
- `results/jacoco-B.csv`
- `results/mvn-test-D-fail.txt`
- `results/mvn-verify-final.txt`
- `results/jacoco-final.csv`

## 10. AI ашиглалт

ChatGPT-ийг тестийн нөхцөлүүдийг ойлгох, Maven болон JaCoCo командуудыг ажиллуулах, алдааны шалтгааныг тайлбарлах, README тайлан боловсруулахад туслах хэрэгсэл болгон ашигласан.
