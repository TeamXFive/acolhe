// Login page JavaScript
document.addEventListener("DOMContentLoaded", () => {
    const loginForm = document.getElementById("loginForm");
    const cpfInput = document.getElementById("cpf");
    const passwordInput = document.getElementById("password");
    const cpfError = document.getElementById("cpf-error");
    const passwordError = document.getElementById("password-error");

    // Add CPF mask - Format as: 000.000.000-00
    cpfInput.addEventListener("input", (e) => {
        let value = e.target.value.replace(/\D/g, "");
        if (value.length > 11) {
            value = value.slice(0, 11);
        }

        let formattedValue = "";
        if (value.length > 0) {
            formattedValue = value.slice(0, 3);
        }
        if (value.length > 3) {
            formattedValue += `.${value.slice(3, 6)}`;
        }
        if (value.length > 6) {
            formattedValue += `.${value.slice(6, 9)}`;
        }
        if (value.length > 9) {
            formattedValue += `-${value.slice(9, 11)}`;
        }

        e.target.value = formattedValue;
    });

    // Form submission
    loginForm.addEventListener("submit", (e) => {
        e.preventDefault();

        // Reset error messages
        cpfError.textContent = "";
        passwordError.textContent = "";

        let isValid = true;

        // Simple validation - just check if fields are empty
        if (!cpfInput.value.trim()) {
            cpfError.textContent = "CPF é obrigatório";
            isValid = false;
        }

        if (!passwordInput.value.trim()) {
            passwordError.textContent = "Senha é obrigatória";
            isValid = false;
        }

        if (isValid) {
            // In a real app, we would do API validation here
            // For demo purposes, just redirect to schedule page
            window.location.href = "schedule.html";
        }
    });
});
