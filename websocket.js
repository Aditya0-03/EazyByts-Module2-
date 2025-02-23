const socket = new WebSocket("ws://localhost:8080/ws/trades");

socket.onmessage = (event) => {
    const trade = JSON.parse(event.data);
    const tradeHistoryDiv = document.getElementById("trade-history");
    const tradeElement = `<p>${trade.symbol} | ${trade.price} | ${trade.quantity} | ${trade.buy ? 'Buy' : 'Sell'}</p>`;
    
    tradeHistoryDiv.innerHTML = tradeElement + tradeHistoryDiv.innerHTML;
};

socket.onopen = () => console.log("WebSocket connected");
socket.onerror = (error) => console.error("WebSocket Error", error);
