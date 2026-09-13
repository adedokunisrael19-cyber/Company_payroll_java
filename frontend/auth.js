const BASE_URL = "http://localhost:8080/auth";

const showToast = (message) => {
    const toast = document.getElementById("toast");
    toast.textContent = message;
    toast.classList.add("show");
    
    setTimeout(() => {
        toast.classList.remove("show");
    }, 3000);
};

const registerUser = async (event) => {
    event.preventDefault();    
    const fullName = document.getElementById("register-fullname").value.trim();
    const email = document.getElementById("register-email").value.trim();
    const password = document.getElementById("register-password").value.trim();

    if (!fullName || !email || !password) {
        showToast("Please fill in all registration fields.");
        return;
    }

    try {
        const response = await fetch(`${BASE_URL}/register`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ fullName, email, password })
        });

        if (response.ok) {
            window.location.href = "login.html";
        } else {
            showToast("Registration failed. Email already exists.");
        }
    } catch (error) {
        showToast("Unable to connect to the server.");
        console.error(error);
    }
};

const loginUser = async (event) => {
    event.preventDefault();
    const email = document.getElementById("login-email").value.trim();
    const password = document.getElementById("login-password").value.trim();

    if (!email || !password) {
        showToast("Please fill in all login fields.");
        return;
    }

    try {
        const response = await fetch(`${BASE_URL}/login`, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ email, password })
        });

        if (response.ok) {
            const userProfile = await response.json();
            
            localStorage.setItem("loggedInUser", JSON.stringify(userProfile));
            
            window.location.href = "index.html";
        } else {
            showToast("Incorrect email or password.");
        }
    } catch (error) {
        showToast("Unable to connect to the server.");
        console.error(error);
    }
};

const registerBtn = document.getElementById("register-submit-btn");
if (registerBtn) {
    registerBtn.addEventListener("click", registerUser);
}

const loginBtn = document.getElementById("login-submit-btn");
if (loginBtn) {
    loginBtn.addEventListener("click", loginUser);
}
