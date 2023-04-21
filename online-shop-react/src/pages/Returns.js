
import Categories from "../components/categories-menu";
import { useTranslation } from 'react-i18next';

export default function Returns() {
  const { t } = useTranslation();
    return (
      <div>
        <Categories/>
        <h1 style={{textAlign: "center"}}>{t('returns')}</h1>
        {/*----------------------------------------------------------------------------------*/}
        <h1>{t('returnhead1')}</h1>
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