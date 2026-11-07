Singharay CRM Android WebView Project

এটি Android Studio ছাড়াই অনলাইন Build Service-এ APK তৈরির জন্য একটি Android project।
বর্তমান CRM HTML assets/index.html-এ রাখা আছে, কিন্তু MainActivity বর্তমানে live Firebase Hosting URL খুলছে।

APK বানানোর সহজ পথ:
1) ZIP extract করুন।
2) GitHub-এ নতুন repository তৈরি করে এই project-এর সব ফাইল upload করুন।
3) Codemagic / অন্য Android cloud build service-এ repository connect করুন।
4) Android build workflow চালিয়ে APK artifact নিন।

গুরুত্বপূর্ণ:
- এই ZIP নিজে APK নয়; এখানে APK compile করা হয়নি।
- Firebase Authentication/Firestore-এর জন্য ইন্টারনেট দরকার।
- Push notification (FCM) এখনও আলাদা Firebase Android app setup + FCM server/Cloud Function চাই।
- Technician/Admin login এবং Firebase permissions বাস্তবে পরীক্ষা করে নিন।
