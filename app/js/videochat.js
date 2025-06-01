// Video chat page JavaScript
document.addEventListener("DOMContentLoaded", () => {
    // DOM elements
    const userVideo = document.getElementById("userVideo");
    const chatPanel = document.getElementById("chatPanel");
    const toggleChatBtn = document.getElementById("toggleChatBtn");
    const messageInput = document.getElementById("messageInput");
    const sendMessageBtn = document.getElementById("sendMessageBtn");
    const chatMessages = document.getElementById("chatMessages");
    const toggleMicBtn = document.getElementById("toggleMicBtn");
    const toggleCameraBtn = document.getElementById("toggleCameraBtn");
    const shareScreenBtn = document.getElementById("shareScreenBtn");
    const endCallBtn = document.getElementById("endCallBtn");

    // State variables
    let isChatOpen = true;
    let isMicOn = true;
    let isCameraOn = true;
    let isScreenSharing = false;
    let stream = null;

    // Initialize user video
    async function initializeUserVideo() {
        try {
            stream = await navigator.mediaDevices.getUserMedia({
                video: true,
                audio: true,
            });
            userVideo.srcObject = stream;
        } catch (error) {
            console.error("Error accessing camera and microphone:", error);
            // Show a camera-off state for user as well if access denied
            userVideo.parentElement.innerHTML = `
                <div class="avatar-placeholder">
                    <i class="fas fa-user"></i>
                    <div class="camera-off-indicator">
                        <i class="fas fa-video-slash"></i>
                        <span>Câmera desligada</span>
                    </div>
                </div>
                <div class="participant-name">Você</div>
            `;
        }
    }

    // Toggle chat panel visibility
    function toggleChat() {
        isChatOpen = !isChatOpen;
        chatPanel.classList.toggle("collapsed", !isChatOpen);
        toggleChatBtn.innerHTML = isChatOpen
            ? '<i class="fas fa-chevron-right"></i>'
            : '<i class="fas fa-chevron-left"></i>';
    }

    // Toggle microphone
    function toggleMic() {
        isMicOn = !isMicOn;
        toggleMicBtn.innerHTML = isMicOn
            ? '<i class="fas fa-microphone"></i>'
            : '<i class="fas fa-microphone-slash"></i>';
        toggleMicBtn.classList.toggle("active", !isMicOn);

        if (stream) {
            stream.getAudioTracks().forEach((track) => {
                track.enabled = isMicOn;
            });
        }
    }

    // Toggle camera
    function toggleCamera() {
        isCameraOn = !isCameraOn;
        toggleCameraBtn.innerHTML = isCameraOn
            ? '<i class="fas fa-video"></i>'
            : '<i class="fas fa-video-slash"></i>';
        toggleCameraBtn.classList.toggle("active", !isCameraOn);

        if (stream) {
            stream.getVideoTracks().forEach((track) => {
                track.enabled = isCameraOn;
            });
        }
    }

    // Simulate screen sharing (just a toggle in this demo)
    function toggleScreenShare() {
        isScreenSharing = !isScreenSharing;
        shareScreenBtn.classList.toggle("active", isScreenSharing);
    }

    // Send a message
    function sendMessage() {
        const messageText = messageInput.value.trim();
        if (messageText) {
            const now = new Date();
            const timeString =
                now.getHours().toString().padStart(2, "0") +
                ":" +
                now.getMinutes().toString().padStart(2, "0");

            const messageHTML = `
                <div class="message user">
                    <span class="sender">Você</span>
                    <p>${messageText}</p>
                    <span class="time">${timeString}</span>
                </div>
            `;

            chatMessages.insertAdjacentHTML("beforeend", messageHTML);
            messageInput.value = "";
            chatMessages.scrollTop = chatMessages.scrollHeight;

            // Simulate professional response after a short delay
            setTimeout(
                simulateProfessionalResponse,
                1000 + Math.random() * 2000
            );
        }
    }

    // Simulate a response from the professional
    function simulateProfessionalResponse() {
        const responses = [
            "Como você se sente em relação a isso?",
            "Pode me contar mais sobre isso?",
            "Entendo como você se sente. Vamos explorar isso.",
            "É normal sentir-se assim na sua situação.",
            "Você já tentou alguma técnica de relaxamento que conversamos?",
            "Vamos trabalhar juntos para encontrar estratégias que funcionem para você.",
        ];

        const randomResponse =
            responses[Math.floor(Math.random() * responses.length)];
        const now = new Date();
        const timeString =
            now.getHours().toString().padStart(2, "0") +
            ":" +
            now.getMinutes().toString().padStart(2, "0");

        const messageHTML = `
            <div class="message professional">
                <span class="sender">Dra. Ana Silva</span>
                <p>${randomResponse}</p>
                <span class="time">${timeString}</span>
            </div>
        `;

        chatMessages.insertAdjacentHTML("beforeend", messageHTML);
        chatMessages.scrollTop = chatMessages.scrollHeight;
    }

    // End call and return to schedule
    function endCall() {
        if (confirm("Deseja encerrar esta sessão?")) {
            window.location.href = "schedule.html";
        }
    }

    // Event listeners
    toggleChatBtn.addEventListener("click", toggleChat);
    toggleMicBtn.addEventListener("click", toggleMic);
    toggleCameraBtn.addEventListener("click", toggleCamera);
    shareScreenBtn.addEventListener("click", toggleScreenShare);
    endCallBtn.addEventListener("click", endCall);

    sendMessageBtn.addEventListener("click", sendMessage);
    messageInput.addEventListener("keypress", function (e) {
        if (e.key === "Enter") {
            sendMessage();
        }
    });

    // Initialize
    initializeUserVideo();
});
