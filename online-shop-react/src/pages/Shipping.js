import Categories from "../components/categories-menu";
import { useTranslation } from 'react-i18next';

export default function Shipping() {
  const { t } = useTranslation();
    return (
      <div>
        <Categories/>
        <h1 style={{textAlign: "center"}}>{t('shipping')}</h1>
        {/*----------------------------------------------------------------------------------*/}
        <h1>{t('shiphead1')}</h1>
        <h3>
        {t('shipbody1')}
        </h3>
        <b2>

        </b2>
        {/*----------------------------------------------------------------------------------*/}
        <h1>{t('shiphead2')}</h1>
        <h3>
        {t('shipbody2')}
        </h3>
        <b2>

        </b2>
        {/*----------------------------------------------------------------------------------*/}
        <h1>{t('shiphead3')}</h1>
        <h3>
        {t('shipbody2')}
        </h3>
        {/*----------------------------------------------------------------------------------*/}
      
      </div>
    );
    
  }