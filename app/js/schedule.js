document.addEventListener("DOMContentLoaded", () => {
    const logoBtn = document.querySelector(".navbar > .logo");
    const logoutBtn = document.getElementById("logoutBtn");
    const newSessionBtn = document.getElementById("newSessionBtn");
    const sessionCards = document.querySelectorAll(".session-card");
    const joinButtons = document.querySelectorAll(".join-btn");

    logoutBtn.addEventListener("click", () => {
        // TODO: Implemetar logica de logout
        window.location.href = "/login.html";
    });

    logoBtn.addEventListener("click", () => {
        window.location.href = "/login.html";
    });

    newSessionBtn.addEventListener("click", () => {
        alert("Funcionalidade de agendamento será implementada no futuro.");
    });

    for (const button of joinButtons) {
        button.addEventListener("click", function () {
            const sessionId =
                this.closest(".session-card").getAttribute("data-id");
            window.location.href = `videochat.html?session=${sessionId}`;
        });
    }
});
