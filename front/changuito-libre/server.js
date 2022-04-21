const express = require('express')
const path = require('path')

const app = express()

app.use(express.static('.dist/changuito-libre'));

app.get('/*', (req, res) =>
    res.sendFile('index.html', {root: 'dist/changuito-libre/'}),
);


app.listen(process.env.PORT || 4200);
