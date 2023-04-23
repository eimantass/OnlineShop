import '../components/css/FooterMenu.css';
import { useTranslation } from 'react-i18next';


export default function About() {
    const { t } = useTranslation();
    return (
      <div>
        <h1 className="headText">{t('about')}</h1>
        <h3>
        {t('aboutMain')}
        </h3>
        <b2>

        </b2>
        <h2> {t('vision')}</h2>
        <h3>
            {t('visionBody')}
        </h3>
        <b2>

        </b2>
        <h2> {t('goals')}</h2>
        <h3>
              {t('goalsBody')}
        </h3>
        <b2>

        </b2>
        <h2>{t('values')}</h2>
        <h3>
          <ul>
        <li>  {t('values1')}</li>
        <li> {t('values2')}</li>
        <li> {t('values3')}</li>
        </ul>
        </h3>
      </div>
    );
    
  }