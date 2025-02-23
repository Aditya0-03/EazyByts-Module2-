const BASE_URL = "http://localhost:9090/api"; // Adjust based on your backend URL

async function register(username, password, email) {
    try {
        const response = await fetch(`${BASE_URL}/register`, {
            method: "POST",
            headers: { 
                "Content-Type": "application/json",
                "Accept": "application/json"
            },
            body: JSON.stringify({ username, password, email })
        });

        // Check if the response status is OK (200-299)
        if (!response.ok) {
            const errorData = await response.json();
            console.error("Registration Error:", errorData.message || "Unknown error");
            return { success: false, message: errorData.message || "Registration failed" };
        }

        // Parse JSON response
        const data = await response.json();
        
        if (data.success) {
            console.log("✅ Registration successful:", data);
        } else {
            console.warn("⚠️ Registration failed:", data);
        }

        return data; // { success: true/false, message: "..."}
        
    } catch (error) {
        console.error("🚨 API Error:", error);
        return { success: false, message: "Server error. Try again later." };
    }
}
