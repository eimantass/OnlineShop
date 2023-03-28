import React from 'react';
import TopMenu from '../layout/TopMenu';
import Body from '../layout/Body';
import FooterMenu from '../layout/FooterMenu';
import SeachAndLogo from '../layout/searchandlogo';

export function Home() {

  return (
    <>
      <TopMenu/>
      <SeachAndLogo/>
      <Body/>
      <FooterMenu/>
    </>
      
    );
  }
