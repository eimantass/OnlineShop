import React from 'react';
import TopMenu from '../TopMenu';
import Body from '../Body';
import FooterMenu from '../FooterMenu';
import SeachAndLogo from '../searchandlogo';

import '../css/App.css'

export function Home() {

  return (
    <div className="FooterPlacer">
      <TopMenu/>
      <SeachAndLogo/>
      <Body/>
      <FooterMenu/>
    </div>
      
    );
  }
