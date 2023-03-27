import React from 'react';
import TopMenu from '../TopMenu';
import Body from '../Body';
import FooterMenu from '../FooterMenu';
import SeachAndLogo from '../searchandlogo';

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
