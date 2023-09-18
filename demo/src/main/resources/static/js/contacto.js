// first javascript file 
function namesConstraint(nombre) {

    if(nombre.length > 49){
        charsName.style.visibility = 'visible';
    }else{
        charsName.style.visibility = 'hidden';
    }

}

function lastNConstraint (ln) {

    if(ln.length > 49){
        charslst.style.visibility = 'visible';
    }else{
        charslst.style.visibility = 'hidden';
    }

}

function dateConstraint (date) {

    if(date.length > 0){
        charDate.style.visibility = 'hidden';
    }else{
        charDate.style.visibility = 'visible';
    }

}

function ageConstraint (age){

    if(Math.trunc(parseFloat(age)) != parseFloat(age)){
        charAge01.style.visibility = 'visible';
    } else if(parseFloat(age) > 9){
        charAge02.style.visibility = 'visible';
    }else{
        charAge01.style.visibility = 'hidden';
        charAge02.style.visibility = 'hidden';
    }

}