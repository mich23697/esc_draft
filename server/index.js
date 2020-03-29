const express = require('express');
const bodyParser = require('body-parser');
const cors = require('cors');

const app = express();
const port = process.env.PORT||3000;

let submissions = [];

app.use(bodyParser.json());
app.use(cors());

app.get('/', function(req, res) {
	res.json({
		message: "Hello World!"
	});
});

app.post('/submit', function(req, res){
	submissions.push(req.body);
	console.log("Submission received:");
	console.log(req.body);
	console.log(submissions);
	res.status(201)
})

app.get('/submissions', function(req,res){
	res.json(submissions);
})

app.listen(port, function(){
	console.log('listening on port: ' + port);
});
