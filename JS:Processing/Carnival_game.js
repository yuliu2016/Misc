//-----------------
//====Variables====
//-----------------
var _status = 0;
var speed = 15;
var rand = -1;
var fcount = 0;
var won = false;
var right_direction = true;
var tans = [0, 98, 168, 232, 302, 400];
var active_sprites = [];
var sprites = {
    start_button: {
        x: 100,
        y: 300,
        width: 200,
        height: 50,
        fillcolor: color(0, 64, 192),
        mclick: function () {
            active_sprites = [];
            _status = 2;
        },
        mhover: function () {
            this.fillcolor = color(0, 96, 224);
            this.draw();
        },
        munhover: function () {
            this.fillcolor = color(0, 64, 192);
            this.draw();
        },
        draw: function () {
            noStroke();
            textFont(createFont("Comic Sans MS"), 20);
            fill(this.fillcolor);
            rect(this.x, this.y, this.width, this.height, 50);
            fill(255, 255, 255);
            text("START", 165, 315, 200, 50);
        }
    },
    ball: {
        x: 175,
        y: 100,
        width: 50,
        height: 50,
        fillcolor: color(0, 255, 0),
        draw: function () {
            noStroke();
            fill(this.fillcolor);
            ellipse(this.x + this.width / 2, this.y + this.height / 2, this.width, this.height);
        },
        mhover: function () {
            this.fillcolor = color(255, 0, 255);
        },
        munhover: function () {
            this.fillcolor = color(0, 255, 0);
        }
    },
    go_button : {
        x: 175,
        y: 325,
        width: 50,
        height: 50,
        fillcolor: color(128, 128, 128),
        strokecolor: color(128, 128, 128),
        bgfill: color(240, 240, 240),
        draw: function () {
            fill(this.bgfill);
            stroke(this.strokecolor);
            strokeWeight(2);
            ellipse(this.x + this.width / 2, this.y + this.height / 2, this.width, this.height);
            fill(this.fillcolor);
            textFont(createFont("Comic Sans MS"), 20);
            text("GO", 185, 357);
        },
        mclick: function () {
            won = false;
            var rd = Math.floor(Math.random() * 6);
            _status = 4;
            rand = rd;
            
            var min_er = tans[rand - 1] || 0;
            var max_er = tans[rand + 1] || 400;
            var min = min_er + (tans[rand] - min_er) / 2;
            var max = max_er - (max_er - tans[rand]) / 2;
            var ball = active_sprites[0];
            if (ball.x >= min && ball.x <= max && ball.x < 232 && ball.x > 168) {
                print("blue ");
                won = true;
            } else {
                print("green ");
            }
            print(rand);
        },
        mhover: function () {
            this.bgfill = color(0, 128, 192);
            this.fillcolor = color(255, 255, 255);
            this.strokecolor = color(0, 128, 192);
        },
        munhover: function () {
            this.bgfill = color(240, 240, 240);
            this.fillcolor = color(128, 128, 128);
            this.strokecolor = color(128, 128, 128);
        }
    }
};

//--------------------
//====CALCULATIONS====
//--------------------

var update_ball_pos = function () {
    var ball = active_sprites[0];
    if (ball.x + ball.width >= width || ball.x  <= 0) {
        right_direction = !right_direction;
    }
    ball.x = ball.x + speed * (right_direction ? 1 : -1);
};

//---------------------
//====SCENE DRAWING====
//---------------------

var d_anglepaths = function () {
    stroke(128, 128, 128);
    strokeWeight(1);
    for (var i = 0; i < 6; i++) {
        line(200, 325, tans[i], 125);
    }
};

var d_sprites = function () {
    for (var i = 0; i < active_sprites.length; i++) {
        active_sprites[i].draw();
    }
};

var d_startscene = function () {
    background(64, 64, 64);
    fill(255, 255, 255);
    noStroke();
    textFont(createFont("Comic Sans MS"), 22);
    text("Click the Start button to start your game. You win if the arrow hits the moving ball when it's blue \n\n Good Luck!", 25, 50, 350, 400);
    active_sprites.push(sprites.start_button);
    d_sprites();
};

var d_gamescene = function () {
    background(240, 240, 240);
    active_sprites.push(sprites.ball);
    active_sprites.push(sprites.go_button);
    d_sprites();
};

var d_update = function () {
    background(240, 240, 240);
    stroke(192, 192, 192);
    d_anglepaths();
    update_ball_pos();
    var ball = active_sprites[0];
    if(ball.x +25 > tans[2] && ball.x +25 < tans[3]){
        ball.fillcolor = color(0, 0, 255);
    } else {
        ball.fillcolor = color(0, 255, 0);
    }
    d_sprites();
};

var d_updatewitharrow = function () {
    d_update();
    strokeWeight(3);
    stroke(255, 0, 0);
    line(200, 325, tans[rand], 125);
};

var d_final = function () {
    active_sprites = [];
    if(won){
        background(64, 0, 0);
        println("win");
        noLoop();
    } else {
        println("loss");
    }
    _status = 2;
    fcount =0;
};

//--------------
//====EVENTS====
//--------------

mouseClicked = function () {
    var button;
    for (var i = 0; i < active_sprites.length; i++) {
        button = active_sprites[i];
        if(button.x < mouseX && mouseX < button.x + button.width && button.y < mouseY && mouseY < button.y + button.height){
            button.mclick();
        }
    }
};

mouseMoved = function () {
    var button;
    for (var i = 0; i < active_sprites.length; i++) {
        button = active_sprites[i];
        if(button.x < mouseX && mouseX < button.x + button.width && button.y < mouseY && mouseY < button.y + button.height){
            button.mhover();
        } else {
            button.munhover();
        }
    }
};

var draw = function() {
    switch (_status) {
        case 0:
            d_startscene();
            _status = 1;
            break;
        case 1:
            break;
        case 2:
            d_gamescene();
            _status = 3;
            break;
        case 3:
            d_update();
            break;
        case 4:debug(_status);
            if (fcount===30) {
                _status = 5;
            }
            d_updatewitharrow();
            fcount++;
            break;
        case 5:
            d_final();
            break;
        default:
        println("Error Default");
    }
};
