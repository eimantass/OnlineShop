import Categories from "../components/categories-menu";
import { useTranslation } from 'react-i18next';

export default function Warranty() {
  const { t } = useTranslation();
    return (
      <div>
        <Categories/>
        <h1 style={{textAlign: "center"}}>{t('warranty')}</h1>
        <h1>{t('warrantyhead1')}</h1>
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