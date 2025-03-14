document.addEventListener('DOMContentLoaded', function() {
    // بارگذاری لیست کاربران در انتظار تایید
    loadPendingAccounts();

    // مدیریت ارسال فرم افزودن دوره
    document.getElementById('addCourseForm').addEventListener('submit', function(event) {
        event.preventDefault(); // جلوگیری از بارگذاری دوباره صفحه
        addNewCourse();
    });
});

// بارگذاری حساب‌های در انتظار تأیید
function loadPendingAccounts() {
    fetch('/signUp/pending-accounts') // درخواست به اندپوینت جدید
        .then(response => {
            if (!response.ok) {
                throw new Error('خطا در بارگذاری حساب‌ها: ' + response.status);
            }
            return response.json(); // به عنوان JSON بخوانید
        })
        .then(data => {
            const pendingUsersList = document.getElementById('pendingUsersList');
            pendingUsersList.innerHTML = ''; // پیش‌فرض محتوا را تخلیه کنید

            if (Array.isArray(data) && data.length > 0) {
                data.forEach(account => {
                    const row = document.createElement('tr');
                    row.innerHTML = `
                        <td>${account.username}</td>
                        <td>${account.enabled ? 'تایید شده' : 'در انتظار تأیید'}</td>
                        <td>
                            <button onclick="approveUser('${account.username}')" ${account.enabled ? 'disabled' : ''}>تایید</button>
                        </td>
                    `;
                    pendingUsersList.appendChild(row);
                });
            } else {
                pendingUsersList.innerHTML = '<tr><td colspan="3">هیچ کاربری در انتظار تأیید وجود ندارد.</td></tr>';
            }
        })
        .catch(error => console.error('خطا در بارگذاری حساب‌ها:', error));
}

// تابع تایید کاربر
function approveUser(username) {
    fetch(`/api/users/${username}/approve`, { method: 'POST' }) // اندپوینت تایید کاربر
        .then(response => {
            if (response.ok) {
                alert(`${username} تایید شد.`);
                loadPendingAccounts(); // تازه‌سازی لیست حساب‌ها
            } else {
                alert('خطا در تایید کاربر. لطفاً دوباره تلاش کنید.');
            }
        })
        .catch(error => console.error('خطا در تایید کاربر:', error));
}

// تابع برای اضافه کردن دوره جدید
function addNewCourse() {
    const courseName = document.getElementById('courseName').value;
    const courseStartDate = document.getElementById('courseStartDate').value;
    const courseEndDate = document.getElementById('courseEndDate').value;

    // بررسی داده‌های ورودی قبل از ارسال
    if (!courseName || !courseStartDate || !courseEndDate) {
        alert('لطفاً تمامی فیلدها را پر کنید.');
        return;
    }

    // ارسال درخواست برای اضافه کردن دوره
    fetch('/api/courses', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            name: courseName,
            startDate: courseStartDate,
            endDate: courseEndDate
        })
    })
        .then(response => {
            if (response.ok) {
                alert('دوره جدید با موفقیت اضافه شد.');
                document.getElementById('addCourseForm').reset(); // پاکسازی فرم
                loadCourses(); // بارگذاری دوباره لیست دوره ها
            } else {
                alert('خطا در اضافه کردن دوره. لطفاً دوباره تلاش کنید.');
            }
        })
        .catch(error => console.error('خطا در اضافه کردن دوره:', error));
}

// تابع برای بارگذاری دوره‌ها (برای بارگذاری دوره‌ها پس از اضافه کردن)
function loadCourses() {
    fetch('/api/courses') // فرض بر این است که این اندپوینت دوره‌ها را نیز ارائه می‌دهد
        .then(response => response.json())
        .then(courses => {
            const coursesList = document.getElementById('coursesList');
            coursesList.innerHTML = ''; // پاکسازی محتوای قبلی

            if (Array.isArray(courses) && courses.length > 0) {
                courses.forEach(course => {
                    const courseDiv = document.createElement('div');
                    courseDiv.innerHTML = `
                        <strong>${course.name}</strong> - ${course.startDate} تا ${course.endDate}
                    `;
                    coursesList.appendChild(courseDiv);
                });
            } else {
                coursesList.innerHTML = '<p>هیچ دوره‌ای وجود ندارد.</p>';
            }
        })
        .catch(error => console.error('خطا در بارگذاری دوره‌ها:', error));
}