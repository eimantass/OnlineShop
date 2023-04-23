import { useTranslation } from 'react-i18next';

export default function Shipping() {
  const { t } = useTranslation();
    return (
      <div>
        <h1 className="headText">{t('shipping')}</h1>
        {/*----------------------------------------------------------------------------------*/}
        <h1 className="bigPartText">{t('shiphead1')}</h1>
        <h3>
        {t('shipbody1')}
        </h3>
        <b2>

        </b2>
        {/*----------------------------------------------------------------------------------*/}
        <h1 className="bigPartText">{t('shiphead2')}</h1>
        <h3>
        {t('shipbody2')}
        </h3>
        <b2>

        </b2>
        {/*----------------------------------------------------------------------------------*/}
        <h1 className="bigPartText">{t('shiphead3')}</h1>
        <h3>
        {t('shipbody2')}
        </h3>
        {/*----------------------------------------------------------------------------------*/}
      
      </div>
    );
    
  }