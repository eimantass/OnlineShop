import { useTranslation } from 'react-i18next';
import '../components/css/FooterMenu.css';

export default function Warranty() {
  const { t } = useTranslation();
    return (
      <div>
        <h1 className="headText">{t('warranty')}</h1>
        <h1 className="bigPartText">{t('warrantyhead1')}</h1>
        <h3>
        {t('warrantybody1')}
        </h3>
        <h3>
        {t('warrantybody2')}
        </h3>
        <h3>
        {t('warrantybody3')}
        </h3>
      </div>
    );
    
  }