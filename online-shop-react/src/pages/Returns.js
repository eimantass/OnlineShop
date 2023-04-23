import { useTranslation } from 'react-i18next';
import '../components/css/FooterMenu.css';

export default function Returns() {
  const { t } = useTranslation();
    return (
      <div>
        <h1 className="headText">{t('returns')}</h1>
        {/*----------------------------------------------------------------------------------*/}
        <h1 className="bigPartText">{t('returnhead1')}</h1>
        <h2 style={{ fontWeight: 'bold' }}>{t('returnhead2')}</h2>
        <h3>
        {t('returnbody1')}
        </h3>
        <h3>
        {t('returnbody2')}
        </h3>
        <h3>
        {t('returnbody3')}
        </h3>
        {/*----------------------------------------------------------------------------------*/}
     
      </div>
    );
    
  }