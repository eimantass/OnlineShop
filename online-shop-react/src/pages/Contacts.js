import '../layout/css/Customers.css';
import { useTranslation } from 'react-i18next';

export default function Contacts() {
  const { t } = useTranslation();
    return (
      <div>
        <h1 style={{textAlign: "center"}}>{t('contact')}</h1>
        <ul>
        <h1>{t('contacts')}</h1>
        <b2> </b2>
        <li>{t('contnumber1')}</li>
        <b2> </b2>
        <li>{t('contnumber2')}</li>
        <b2> </b2>
        <li>{t('contnumber3')}</li>
        </ul>
        <ul>
        <h1>{t('contactsel')}</h1>
        <b2> </b2>
        <li> {t('contantmail')}</li>
        </ul>
      
      </div>
    );
    
  }