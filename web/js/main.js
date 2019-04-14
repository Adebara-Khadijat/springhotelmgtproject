            var index = 1; //Global Varable

           imageSlide();
           manualSlide(index);

           function previousSlide(n){
            index = index + n;
            manualSlide(index);
           }

           function nextSlide(n){
            index = index + n;
            manualSlide(index);
           }

           function imageSlide(){
            var slide = document.getElementsByClassName("slide");
            //alert(slide); //it will display [object HTMLCollection] which means it's an array[] which contain set of slides  
            if(index > slide.length){ //the if statement make it to continue looping
              index = 1;
            }; 

            //for it to reset slide contain, it set its to none
            for(var i = 0; i < slide.length; i++){
              slide[i].style.display = "none"; 
            };

            slide[index - 1].style.display = "block"; //only the first slide will display while other slides are hidden
            index = index + 1;
            setTimeout(imageSlide, 5000);
            };     

            function manualSlide(n){ //n means number of index
            var slide = document.getElementsByClassName("slide");

            if(n > slide.length){  //the if statement make it to continue looping
              index = 1;
            } 

            if(n < 1){ //to aviod the user press previous buttom which can lead to negative output or none
              index = slide.length; 
            }
            //reset
            for(var i = 0; i < slide.length; i++){
              slide[i].style.display = "none"; 
            };

            slide[index-1].style.display = "block"; //only the first slide will display while other slides are hidden
            } 