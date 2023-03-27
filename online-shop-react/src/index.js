import React from 'react';
import ReactDOM from 'react-dom/client';
import './css/index.css';
// import App from './App';
import TopMenu from './TopMenu';
import FooterMenu from './FooterMenu';
import Body from './Body';
import ApieMus from './ApieMus';
import {BrowserRouter as Router, Routes, Route} from 'react-router-dom';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(

        <BrowserRouter>
            <App/> 
        </BrowserRouter>         
    
);


