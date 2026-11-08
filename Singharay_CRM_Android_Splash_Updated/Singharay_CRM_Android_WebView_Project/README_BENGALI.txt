Singharay CRM Android + FCM Starter (v1.1)

এই project-এ FCM notification receive করার Android service যোগ করা হয়েছে।
APK build-এর আগে অবশ্যই Firebase Console থেকে Android app (package: com.singharay.crm) register করে google-services.json ডাউনলোড করুন এবং app/ ফোল্ডারে রাখুন।

Build:
1. ZIP extract করুন / GitHub repository-তে updated files upload করুন।
2. Firebase Console > Project settings > Your apps > Add Android app
   Package name: com.singharay.crm
3. google-services.json download করে app/google-services.json হিসেবে রাখুন।
4. Android Studio-তে Sync Gradle, তারপর Build APK।
5. Android 13+ এ notification permission Allow করতে হবে।

গুরুত্বপূর্ণ:
- এই project APK নয়; source project।
- FCM message receiver যোগ হয়েছে, কিন্তু Admin job assign হলে message পাঠানোর Cloud Function/Server sender এখনো তৈরি/Deploy করা হয়নি।
- CRM HTML-এর Technician job workflow আগের মতো live website-এ চলে।
- FCM token logcat-এ SingharayFCM tag দিয়ে দেখা যাবে; secureভাবে token Firestore-এ register করা ও Admin assignment trigger Function পরের ধাপ।
