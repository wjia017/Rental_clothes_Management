<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
    <title>Register - RentalHub</title>

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/register.css">
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet">
    <style>
    @charset "UTF-8";
*{
    margin:0;
    padding:0;
    box-sizing:border-box;
    font-family:'Inter', sans-serif;
}

body{
    height:100vh;
    display:flex;
    align-items:center;
    justify-content:center;
    background: linear-gradient(135deg, #4f46e5, #7c3aed, #2563eb);
    background-size:300% 300%;
    animation: bg 10s infinite;
}

@keyframes bg{
    0%{background-position:0% 50%;}
    50%{background-position:100% 50%;}
    100%{background-position:0% 50%;}
}

.auth-wrapper{
    width:100%;
    display:flex;
    justify-content:center;
}

.auth-card{
    width:900px;
    height:520px;
    display:flex;
    border-radius:20px;
    overflow:hidden;
    background: rgba(255,255,255,0.15);
    backdrop-filter: blur(20px);
    box-shadow:0 20px 50px rgba(0,0,0,0.25);
}

/* LEFT SIDE */
.auth-left{
    flex:1;
    color:white;
    padding:60px;
    display:flex;
    flex-direction:column;
    justify-content:center;
}

.auth-left h1{
    font-size:40px;
    font-weight:700;
}

.auth-left p{
    margin-top:10px;
    opacity:0.9;
}

.features{
    margin-top:30px;
}

.features div{
    margin:10px 0;
    font-size:14px;
}

/* RIGHT SIDE */
.auth-right{
    flex:1;
    background:white;
    padding:50px;
    display:flex;
    flex-direction:column;
    justify-content:center;
}

.auth-right h2{
    font-size:26px;
}

.auth-card{
    border:1px solid rgba(255,255,255,0.2);
}

.sub{
    font-size:13px;
    color:gray;
    margin-bottom:20px;
}

/* INPUT */
.input-box{
    position:relative;
    margin-bottom:18px;
}

.input-box input{
    width:100%;
    padding:14px;
    border:1px solid #ddd;
    border-radius:10px;
    outline:none;
}

.input-box label{
    position:absolute;
    left:12px;
    top:12px;
    font-size:13px;
    color:gray;
    transition:0.2s;
}

.input-box input:focus + label,
.input-box input:valid + label{
    top:-10px;
    left:10px;
    background:white;
    font-size:11px;
    padding:0 5px;
}

/* BUTTON */
.btn{
    width:100%;
    padding:14px;
    background:#4f46e5;
    color:white;
    border:none;
    border-radius:10px;
    cursor:pointer;
    font-weight:600;
    transition:0.3s;
}

.btn:hover{
    background:#3730a3;
}

/* SWITCH */
.switch{
    margin-top:15px;
    font-size:13px;
}

.switch a{
    color:#4f46e5;
    font-weight:600;
    text-decoration:none;
}

.error{
    background:#fee2e2;
    color:#dc2626;
    padding:10px;
    border-radius:8px;
    margin-bottom:15px;
    font-size:13px;
}</style>
</head>

<body>

<div class="auth-wrapper">

    <div class="auth-card">

        <!-- LEFT -->
        <div class="auth-left">
            <h1>ClothRent</h1>
            <p>Join smart clothing rental system</p>

            <div class="features">
                <div>👕 Fashion rentals</div>
                <div>🚚 Easy delivery</div>
                <div>💳 Secure system</div>
            </div>
        </div>

        <!-- RIGHT -->
        <div class="auth-right">

            <h2>Create Account</h2>
            <p class="sub">Join ClothRent today</p>

            <% if(request.getAttribute("error") != null) { %>
                <div class="error"><%= request.getAttribute("error") %></div>
            <% } %>

            <c:if test="${param.success == 1}">
    <div style="background:#d1fae5;color:#065f46;padding:10px;border-radius:8px;margin-bottom:10px;">
        ✅ Registered Successfully! Please login.
    </div>
</c:if>

            <form action="${pageContext.request.contextPath}/register" method="post">

    <div class="input-box">
        <input type="text" name="firstName" required>
        <label>First Name</label>
    </div>

    <div class="input-box">
        <input type="text" name="lastName" required>
        <label>Last Name</label>
    </div>

    <div class="input-box">
        <input type="text" name="username" required>
        <label>Username</label>
    </div>

    <div class="input-box">
        <input type="email" name="email" required>
        <label>Email</label>
    </div>

    <div class="input-box">
        <input type="text" name="phone" required>
        <label>Phone</label>
    </div>

    <div class="input-box">
        <input type="password" name="password" required>
        <label>Password</label>
    </div>

    <button type="submit" class="btn">Create Account</button>

</form>

            <p class="switch">
                Already have account?
                <a href="${pageContext.request.contextPath}/login">Sign In</a>
            </p>

        </div>

    </div>

</div>

</body>
</html>