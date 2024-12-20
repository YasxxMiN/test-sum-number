document.getElementById('calculateBtn').addEventListener('click', async () => {
    const numbers = document.getElementById('numbers').value.trim(); // ดึงค่าจาก input
    if (!numbers) {
        alert("Please enter numbers separated by semicolons!");
        return;
    }

    try {
        const response = await fetch("http://localhost:8080/customer-info/calculate", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify( numbers ),
        });
    
        const result = await response.json();
        const data = result.data;
        document.getElementById('odd').value = data.oddNumbers;
        document.getElementById('even').value = data.evenNumbers;
        document.getElementById('oddAverahe').value = data.oddAverage;
        document.getElementById('evenAverage').value = data.evenAverage;
        document.getElementById('Average').value = data.result;
      } catch (error) {
        console.error("Error sending API:", error);
      }
});

document.getElementById('clearBtn').addEventListener('click', () => {
        document.getElementById('odd').value = '';
        document.getElementById('even').value = '';
        document.getElementById('oddAverahe').value = '';
        document.getElementById('evenAverage').value = '';
        document.getElementById('Average').value = '';
        document.getElementById('numbers').value = '';
});