import Categories from '../components/categories-menu';
import '../layout/css/Customers.css';
import { useTranslation } from 'react-i18next';

export default function Help() {
  const { t } = useTranslation();
    return (
      <div>
        <Categories/>
        <ul>
        <h1 style={{textAlign: "center"}}>{t('help')}</h1>
        <h1>{t('helpphone')}</h1>
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
        <ul>
        <h1>{t('helpemail')}</h1>
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