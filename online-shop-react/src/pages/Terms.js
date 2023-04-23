import { useTranslation } from 'react-i18next';

export default function Terms() {
  const { t } = useTranslation();
    return (
      <div>
        <h1 className="headText">{t('terms')}</h1>
        {/*----------------------------------------------------------------------------------*/}
        <h1 className="bigPartText">{t('termshead1')}</h1>
        <h3>
            {t('termsbody1')}
        </h3>
        <b2>

        </b2>
        {/*----------------------------------------------------------------------------------*/}
        <h1 className="bigPartText">{t('termshead2')}</h1>
        <h3>
            {t('termsbody2')}
        </h3>
        <b2>

        </b2>
        {/*----------------------------------------------------------------------------------*/}
        
      </div>
    );
    
  }