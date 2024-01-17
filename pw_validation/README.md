# PwValidation

This project was generated with [Angular CLI](https://github.com/angular/angular-cli) version 15.2.10.

1. If you do not have Node(Which I'm assuming you do) please download it.  I used version 20.
2. In this directory run the following command: "npm install"
3. To run the server, please run the command: "npm run start"
3. On your browser go to localhost:4200/validate and you will see a text box and a validate button.
4. The validate buttons sends a post request over to the spring server running on localhost:8082/user/update
5. Depending upon your input, you will be notified if your password validates, and if not, the reasons why.
