const express = require("express");
const bodyParser = require("body-parser");

const app = express();
const port = 3000;

app.use(bodyParser.json());

let orders = []; 
let nextId = 1;  

app.post("/orders", (req, res) => {
    const { customerName, totalPrice } = req.body;

    if (!customerName || typeof totalPrice !== "number" || totalPrice <= 0) {
        return res.status(400).send({ error: "Invalid input data" });
    }

    const order = { id: nextId++, customerName, totalPrice };
    orders.push(order);
    res.status(201).send(order);
});

app.get("/orders", (req, res) => {
    res.status(200).send(orders);
});

app.get("/orders/:id", (req, res) => {
    const id = parseInt(req.params.id);
    const order = orders.find(o => o.id === id);

    if (!order) return res.status(404).send();
    res.status(200).send(order);
});

app.put("/orders/:id", (req, res) => {
    const id = parseInt(req.params.id);
    const { customerName, totalPrice } = req.body;
    const order = orders.find(o => o.id === id);

    if (!order) return res.status(404).send();
    if (!customerName || typeof totalPrice !== "number" || totalPrice <= 0) {
        return res.status(400).send({ error: "Invalid input data" });
    }

    order.customerName = customerName;
    order.totalPrice = totalPrice;
    res.status(200).send(order);
});

app.delete("/orders/:id", (req, res) => {
    const id = parseInt(req.params.id);
    const index = orders.findIndex(o => o.id === id);

    if (index === -1) return res.status(404).send();

    orders.splice(index, 1);
    res.status(200).send();
});

app.listen(port, () => {
    console.log(`Server running at http://localhost:${port}`);
});