import React from 'react';
import ReactDOM from 'react-dom/client';
import './css/index.css';
// import App from './App';
import TopMenu from './TopMenu';
import FooterMenu from './FooterMenu';
import Body from './Body';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
 
    <div className = "align">
    <TopMenu/>
    <Body/>
    <FooterMenu/>
    </div>


);


