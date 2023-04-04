import React from 'react';
import TopMenu from '../layout/TopMenu';
import Body from '../layout/Body';
import FooterMenu from '../layout/FooterMenu';
import SeachAndLogo from '../layout/searchandlogo';

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
