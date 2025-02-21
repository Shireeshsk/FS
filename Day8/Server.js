const websocket= require("ws");

const server =new websocket.Server({port:8080});
let employees=[];
let idx=1;

server.on("connection",(ws)=>{
    console.log('Connected to server');
    ws.on("message",(message)=>{
        console.log(`Received: ${message}`);
        const parts=message.toString().split(" ");
        if(parts[0]==="INSERT" && parts.length===3){
            const name=parts[1];
            const salary=parseInt(parts[2]);
            if(!isNaN(salary)){
                employees.push({id:idx++,name,salary});
                ws.send('Employee inserted successfully.');
            }else{
                ws.send('Invalid command.');
            }
        }
        else if(parts[0]==="RETRIEVE"){
            if(employees.length===0){
                ws.send('No employees found.');
            }else{
                employees.forEach(e=>{
                    ws.send(`ID: ${e.id}, Name: ${e.name}, Salary: ${e.salary}`);
                })
            }
        }else{
            ws.send("Invalid command.");
        }

    })
    ws.on('close',()=>{
        console.log('Client disconnected');
    })
})
console.log(`Websocket is running on ws://localhost:8080`);