<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>ClothRent Login</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@400;500;600;700&display=swap" rel="stylesheet">
    <style>
    * {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Inter', sans-serif;
}

body {
    height: 100vh;
    display: flex;
    justify-content: center;
    align-items: center;
    overflow: hidden;
    background: #0f0f1a;
}

/* Animated gradient background */
.bg-animation {
    position: absolute;
    width: 100%;
    height: 100%;
    background: linear-gradient(-45deg, #6a5af9, #8f6cff, #4facfe, #00f2fe);
    background-size: 400% 400%;
    animation: gradient 10s ease infinite;
    z-index: -1;
    filter: blur(40px);
}

@keyframes gradient {
    0% { background-position: 0% 50%; }
    50% { background-position: 100% 50%; }
    100% { background-position: 0% 50%; }
}

/* Layout */
.container {
    display: flex;
    width: 900px;
    height: 520px;
    border-radius: 20px;
    overflow: hidden;
    backdrop-filter: blur(20px);
    background: rgba(255,255,255,0.08);
    box-shadow: 0 20px 60px rgba(0,0,0,0.3);
}

/* LEFT PANEL */
.left-panel {
    flex: 1;
    background: rgba(255,255,255,0.05);
    color: white;
    display: flex;
    flex-direction: column;
    justify-content: center;
    padding: 40px;
}

/* RIGHT PANEL */
.login-card {
    flex: 1;
    background: rgba(255,255,255,0.9);
    padding: 50px;
    display: flex;
    flex-direction: column;
    justify-content: center;
}

/* INPUTS */
.input-group {
    position: relative;
    margin: 20px 0;
}

.input-group input {
    width: 100%;
    padding: 14px;
    border: 1px solid #ddd;
    border-radius: 10px;
    outline: none;
    transition: 0.3s;
}

.input-group label {
    position: absolute;
    left: 12px;
    top: 14px;
    color: #888;
    transition: 0.3s;
    pointer-events: none;
}

/* Floating label */
.input-group input:focus + label,
.input-group input:valid + label {
    top: -10px;
    left: 10px;
    font-size: 12px;
    background: white;
    padding: 0 5px;
    color: #6a5af9;
}

/* PASSWORD ICON */
.password-box span {
    position: absolute;
    right: 10px;
    top: 12px;
    cursor: pointer;
}

/* BUTTON */
.btn {
    width: 100%;
    padding: 14px;
    border: none;
    border-radius: 10px;
    background: #6a5af9;
    color: white;
    font-weight: 600;
    cursor: pointer;
    transition: 0.3s;
    margin-top: 10px;
}

.btn:hover {
    transform: translateY(-2px);
}

/* ERROR */
.error {
    background: #ffe5e5;
    color: red;
    padding: 10px;
    border-radius: 8px;
    margin-bottom: 10px;
}

/* LOADING SPINNER */
.spinner {
    display: none;
    width: 14px;
    height: 14px;
    border: 2px solid white;
    border-top: 2px solid transparent;
    border-radius: 50%;
    animation: spin 1s linear infinite;
    margin-right: 8px;
}

@keyframes spin {
    100% { transform: rotate(360deg); }
}</style>
</head>

<body>

<div class="bg-animation"></div>

<div class="container">

    <!-- LEFT INFO PANEL -->
    <div class="left-panel">
        <h1>RentalHub</h1>
        <p>Smart clothing rental system</p>
    </div>

    <!-- RIGHT LOGIN PANEL -->
    <div class="login-card">

        <h2>Welcome Back</h2>
        <p>Sign in to continue</p>

        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/login" method="post">

            <div class="input-group">
                <input type="text" name="username">
                <label>Username</label>
            </div>

            <div class="input-group password-box">
                <input type="password" name="password" id="password" required>
                <label>Password</label>
                <span onclick="togglePassword()">👁</span>
            </div>

            <button type="submit" class="btn">
                <span class="spinner"></span>
                Login
            </button>

        </form>

        <a href="${pageContext.request.contextPath}/register">Create account</a>

    </div>
</div>

<script>
function togglePassword() {
    const pass = document.getElementById("password");
    pass.type = pass.type === "password" ? "text" : "password";
}
</script>

</body>
</html>