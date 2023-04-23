import '../components/css/FooterMenu.css';
import { useTranslation } from 'react-i18next';

export default function Help() {
  const { t } = useTranslation();
    return (
      <div>
        <h1 className="headText">{t('help')}</h1>
        <h1 className="bigPartText" >{t('helpphone')}</h1>
        <ul>
        <b2> </b2>
        <li>{t('helpnumber1')}</li>
        <b2> </b2>
        <li>{t('helpnumber2')}</li>
        <b2> </b2>
        <li>{t('helpnumber3')}</li>
        <b2> </b2>
        <li>{t('helpnumber4')}</li>
        <b2> </b2>
        <li>{t('helpnumber5')}</li>
        </ul>
        <h1 className="bigPartText">{t('helpemail')}</h1>
        <ul>
        <b2> </b2>
        <li> {t('helpemail1')}</li>
        <b2> </b2>
        <li>{t('helpemail2')}</li>
        <b2> </b2>
        <li>{t('helpemail3')} </li>
        <b2> </b2>
        <li>{t('helpemail4')}</li>
        <b2> </b2>
        <li>{t('helpemail5')}</li>
        </ul>
      </div>
    );
    
  }