function validate()
{
    var username = document.getElementById("un").value;
    var email = document.getElementById("ema").value;
    var emcheck = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    var password = document.getElementById("pass").value;
    var cpassword = document.getElementById("cpass").value;
    if(username == "")
    {
        document.getElementById("usn").innerText = "Please enter a username."
        return false;
    }
    if(username.length<5)
    {
        document.getElementById("usn").innerText = "Your username must be at least 5 characters long. "
        return false
    }
    if(username.length>10)
    {
        document.getElementById("usn").innerText = "Your username cannot exceed 10 characters."
        return false
    }  
    if(email == "")
    {
        document.getElementById("em").innerText = "Please enter your email address."
        return false
    }
    if(!emcheck.test(email))
    {
        document.getElementById("em").innerText = "Please enter a valid email address (e.g., user@example.com)."
        return false
    }

    if (password === "") {
        document.getElementById("ps").innerText = "Please create a password.";
        return false;
    }
    if (password.length < 8) {
        document.getElementById("ps").innerText = "Your password must be at least 8 characters long.";
        return false;
    }
    if (!/[A-Z]/.test(password)) {
        document.getElementById("ps").innerText = "Your password must include at least one uppercase letter.";
        return false;
    }
    if (!/[a-z]/.test(password)) {
        document.getElementById("ps").innerText = "Your password must include at least one lowercase letter.";
        return false;
    }
    if (!/[0-9]/.test(password)) {
        document.getElementById("ps").innerText = "Your password must include at least one number.";
        return false;
    }
    if (!/[!@#$%^&*(),.?":{}|<>]/.test(password)) {
        document.getElementById("ps").innerText = "Your password must include at least one special character (e.g., !, @, #).";
        return false;
    }
    if(cpassword == "")
    {
        document.getElementById("cps").innerText = "Please confirm your password."
        return false;
    }
    if(cpassword != password)
    {
        document.getElementById("cps").innerText = "The passwords you entered do not match."
        return false;
    }
    return true;
}
