import Categories from "../components/categories-menu";
import { useTranslation } from 'react-i18next';

export default function Terms() {
  const { t } = useTranslation();
    return (
      <div>
        <Categories/>
        <h1 style={{textAlign: "center"}}>{t('terms')}</h1>
        {/*----------------------------------------------------------------------------------*/}
        <h1>{t('termshead1')}</h1>
        <h3>
            {t('termsbody1')}
        </h3>
        <b2>

        </b2>
        {/*----------------------------------------------------------------------------------*/}
        <h1>{t('termshead2')}</h1>
        <h3>
            {t('termsbody2')}
        </h3>
        <b2>

        </b2>
        {/*----------------------------------------------------------------------------------*/}
        
      </div>
    );
    
  }