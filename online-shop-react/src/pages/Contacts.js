import '../layout/css/Customers.css';
import { useTranslation } from 'react-i18next';

export default function Contacts() {
  const { t } = useTranslation();
    return (
      <div>
        <h1 className="headText">{t('contact')}</h1>
        <h1 className="bigPartText">{t('vadcontacts')}</h1>
        <ul>
        <b2> </b2>
        <li>{t('vadnumber1')}</li>
        <b2> </b2>
        <li>{t('vadnumber2')}</li>
        <b2> </b2>
        <li>{t('vadelp')}</li>
        <b2> </b2>
        <li>{t('vademail')}</li>
        </ul>
        <h1 className="bigPartText">{t('intuž')}</h1>
        <ul>
        <b2> </b2>
        <li> {t('intužvadelp')}</li>
        <b2> </b2>
        <li> {t('intužvadtlf')}</li>
        </ul>
      
      </div>
    );
    
  }