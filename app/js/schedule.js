// Schedule page JavaScript
document.addEventListener("DOMContentLoaded", () => {
    const logoutBtn = document.getElementById("logoutBtn");
    const newSessionBtn = document.getElementById("newSessionBtn");
    const sessionCards = document.querySelectorAll(".session-card");
    const joinButtons = document.querySelectorAll(".join-btn");

    // Handle logout
    logoutBtn.addEventListener("click", () => {
        window.location.href = "login.html";
    });

    // Handle new session button click (would open a modal in a real app)
    newSessionBtn.addEventListener("click", () => {
        alert("Funcionalidade de agendamento será implementada no futuro.");
    });

    // Make session cards clickable
    sessionCards.forEach((card) => {
        card.addEventListener("click", (e) => {
            // Ignore clicks on buttons
            if (e.target.tagName !== "BUTTON") {
                const sessionId = this.getAttribute("data-id");
                // For past sessions, do nothing (or show a different view)
                if (!this.classList.contains("past-session")) {
                    window.location.href = `videochat.html?session=${sessionId}`;
                }
            }
        });
    });

    // Handle join session button clicks
    joinButtons.forEach((button) => {
        button.addEventListener("click", function () {
            const sessionId =
                this.closest(".session-card").getAttribute("data-id");
            window.location.href = `videochat.html?session=${sessionId}`;
        });
    });
});
