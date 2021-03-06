import {
    createHeader
} from './header.js';
import {
    createLogin
} from './login.js';
import {
    createFooter
} from './footer.js';

import {
    createTeacherForm
} from './teacherForm.js';

import {
    createStudentForm
} from './studentForm.js';

import {
    createCourseForm
} from './courseForm.js';

import {
    createUserInfosCard
} from './userInfos.js';

import {
    createAssignment
} from './assignmentForm.js';

import {
    createChatView
} from './chatComponent.js';

import {
    createAssignmentView
} from './assignmentComponent.js';
import {
    translateMessage
} from './translateComponent.js';
import {
    getAllThelanguages
} from './translateComponent.js';


const anchor = document.querySelector('.anchor');
const footerAnchor = document.querySelector('.footer-anchor');
const headerAnchor = document.querySelector('.header-anchor');
let currentUser = '';

const renderLogin = () => {
    while (anchor.firstChild) {
        anchor.removeChild(anchor.firstChild);
    }
    anchor.appendChild(createLogin());
}

const displayFooter = () => {

    footerAnchor.appendChild(createFooter());
}


const displayHeader = () => {

    headerAnchor.appendChild(createHeader());
}

const displayTeacherForm = () => {

    anchor.appendChild(createTeacherForm());
}

const displayStudentForm = () => {

    anchor.appendChild(createStudentForm());
}
const displayCourseForm = () => {

    anchor.appendChild(createCourseForm());
}

const displayAssignmentForm = () => {

    anchor.appendChild(createAssignment());
}

const displayChatView = (chatColor) => {

    anchor.appendChild(createChatView(chatColor));
}

const displayAssignmentView = () => {

    anchor.appendChild(createAssignmentView());
}
const displayMainImage = () => {
    const img  = document.createElement('img');
    img.src = './images/classroomPic.jpg';
    anchor.appendChild(img);
}
const renderLoginView = () => {
    displayHeader();
    displayFooter();
    
    const btn = document.createElement('button');
    btn.innerText = 'USER LOGIN';
    anchor.appendChild(btn);
    
    displayMainImage();
    
    btn.addEventListener('click', () => {
        renderLogin();
    });
}

// const renderTeacherView = () => {

//     // displayHeader();
//     // displayFooter();
//     displayAssignmentView();

//     displayStudentForm();
// }

const displayUserInfos = (user, color) => {


    anchor.appendChild(createUserInfosCard(user, color));
}
const displayTeacherInfo = (JSONresponse) => {
    currentUser = JSONresponse;
    while (anchor.firstChild) {
        anchor.removeChild(anchor.firstChild)
    }
    displayUserInfos(currentUser, 'turquoise');
    displayChatView('turquoise');

}

const displayStudentInfo = (JSONresponse) => {
    currentUser = JSONresponse;
    while (anchor.firstChild) {
        anchor.removeChild(anchor.firstChild)
    }
    //renderStudentView();
    displayUserInfos(currentUser, 'rgb(112, 112, 209)');
    displayChatView('rgb(112, 112, 209)')
}

// translateMessage('en', 'es',
//     'We are coding');
getAllThelanguages();
renderLoginView();

//displayChatView();

// displayUserInfos();
/*displayTeacherForm();
displayCourseForm();
displayAssignmentForm();*/

export {
    currentUser,
    displayTeacherInfo,
    displayStudentInfo
}