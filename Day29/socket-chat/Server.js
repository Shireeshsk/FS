const express = require("express")
const http = require("http")
const websockets = require("ws")

const app = express();
const server = http.createServer(app);
const ws = new websockets.Server({server});
const clients = new Set();

ws.on("connection",(ws)=>{
    console.log("New client connected");
    clients.add(ws);
    ws.on("message",(message)=>{
        console.log(`received : ${message}`);
        clients.forEach(client=>{
            if(client != ws && client.readyState=== websockets.OPEN){
                client.send(message);
            }
        });
    });

    ws.on("close",()=>{
        console.log("client disconnected");
        clients.delete(ws);
    });
});

app.get("/",(req,res)=>{
    res.send("websockets chat server running");
});

const port = 3000;
server.listen(port,()=>{
    console.log(`server is running on http://localhost:${port}`);
})
