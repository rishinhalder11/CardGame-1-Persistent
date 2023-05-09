var xhr = new XMLHttpRequest();
var includedFile;
var player1;
var player2;
var top1;
var top2;
var winner;
var change1=0;
var change2=0;
var change3=0;
var parentDiv1;
var parentDiv2;
var points;
var image1=document.querySelectorAll(".image1");
const myButton1 = document.getElementById("high1");
const myButton2 = document.getElementById("high2");
const myButton3=document.getElementById("decide");
var name1;
var name2;
// var image2=document.querySelectorAll(".image2");
// set the HTTP method and URL for the request
xhr.open('GET', 'game.html');

// define the function to run when the response is received
xhr.onload = function() {
  if (xhr.status === 200) {
    // if the response is successful, insert the HTML into the DOM
    includedFile = document.getElementById('game');
    includedFile.innerHTML = xhr.responseText;
    player1=document.querySelectorAll(".p1");
    player2=document.querySelectorAll(".p2");
    top1=document.querySelector(".high1");
    top2=document.querySelector(".high2");
    winner=document.querySelector(".win");
    points=document.querySelector(".points");
    console.log(points);
    parentDiv1 = top1.parentNode;
    name1=parentDiv1.id; // Get the ID of the parent div element
    //console.log(name1);   // Output the ID of the parent div element"
    document.getElementById("name1").innerHTML="Name : "+name1;
    document.getElementById("name1").style.width="100%"
    parentDiv2 = top2.parentNode;
    name2=parentDiv2.id;
    //console.log(name2); 
    document.getElementById("name2").innerHTML="Name : "+name2;
    document.getElementById("name2").style.width="100%"
  } else {
    // if there was an error, log it to the console
    console.log('Error: ' + xhr.status);
  }
};

// send the request
xhr.send();
  //console.log(image);
  //console.log(player1)

          //console.log(element.getAttribute("data-card"))
          //console.log(element)
          var i=0;
          image1.forEach((picture1,index1) =>{
            
            picture1.addEventListener('click',function flip()
            {

              if(index1<3)
              {
                var data1=player1[index1].getAttribute("data-card");
              
                //picture.innerHTML='<img src="../Assets/"+data+".png"/>'
            
                picture1.childNodes[1].setAttribute('src',"../Assets/"+data1+".png")
                change1++;

              }
              if(change1===3) 
              {
                myButton1.disabled = false;
              }
              
              if(index1>=3)
              {
                var data2=player2[i].getAttribute("data-card");
              
                //picture.innerHTML='<img src="../Assets/"+data+".png"/>'
            
                picture1.childNodes[1].setAttribute('src',"../Assets/"+data2+".png")
                i+=1;
                change2++;
                  
              }
              if(change2===3)
              {
                myButton2.disabled = false;
              }
              console.log(change3);
              if(change1===3 && change2===3)
                myButton3.disabled=false;
            //picture1.childNodes[1].setAttribute('src',"./Assets/"+data2+".png")
            })
            
          });


          // image2.forEach((picture2,index2) =>{
            
          //   picture2.addEventListener('click',function flip()
          //   {
              
          //     var data2=player2[index2].getAttribute("data-card");
          //     if(index2>=3){
          //       var data2=player2[index2];
          //       console.log(data2);
          //     }
              
          //   //picture.innerHTML='<img src="./Assets/"+data+".png"/>'
            
          //   picture2.childNodes[1].setAttribute('src',"./Assets/"+data2+".png")
          //   })
          // });
// Get the HTML element by its ID

// console.log(includedFile.innerHTML);

// Get the value of the data-card attribute using getAttribute() method


// Display the value in the console
//console.log(dataCardValue); // Output: "example"

// var image=document.getElementsByClassName("image");
// function flip(div)
// {
//     div.innerHTML=<img src=`${}`;
// }

// Get the button element


// Add an event listener to the button
myButton1.addEventListener("click", function() {
  
  var data1=top1.getAttribute("data-card");
  console.log(data1);
  // Get the div element
  const myDiv1 = document.getElementById("top1");
  //myDiv1.innerHTML="Highest Card :- "

  // Create an image element
  const myImage1 = document.createElement("img");

  // Set the source URL of the image
  myImage1.src = "../Assets/"+data1+".png";

  // Add the image to the div
  myDiv1.appendChild(myImage1);

});



// Add an event listener to the button
myButton2.addEventListener("click", function() {
  
  var data2=top2.getAttribute("data-card");
  console.log(data2);
  
  // Get the div element
  const myDiv2 = document.getElementById("top2");
  //myDiv2.innerHTML="Highest Card :- "

  // Create an image element
  const myImage2 = document.createElement("img");

  // Set the source URL of the image
  myImage2.src = "../Assets/"+data2+".png";

  // Add the image to the div
  myDiv2.appendChild(myImage2);
});

myButton3.addEventListener("click",function(){

  var best=winner.getAttribute("id");
  const myDiv3=document.getElementById("winner");
  myDiv3.innerHTML="Winner is:-"+best;
  const myDiv4=document.getElementById("points");
  var p=points.getAttribute("id");
  myDiv4.innerHTML="Points Earned:-"+p;
})