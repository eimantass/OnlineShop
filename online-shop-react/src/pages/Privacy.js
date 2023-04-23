import '../layout/css/Customers.css';
import { useTranslation } from 'react-i18next';

export default function Privacy() {
  const { t } = useTranslation();
    return (
      <div>
        <h1 className="headText">{t('privacy')}</h1>
        <h1 className="bigPartText">{t('privacyhead1')}</h1>
        <h3>
        {t('privacyhead2')}
        </h3>
        <h1 className="bigPartText">{t('privacyhead3')}	</h1>
        <h3>
        {t('privacyhead4')}
        </h3>
<h3>{t('privacyhead5')}</h3>
<ul>
  <li>{t('privacylist1')}</li>
  <li>{t('privacylist2')}</li>
  <li>{t('privacylist3')}</li>
  <li>{t('privacylist4')}</li>
  <li>{t('privacylist5')}</li>

  <li>
  {t('privacylist6')}
  </li>
</ul>

<h1 className="bigPartText">{t('privacybody1')}</h1>
<h3>
{t('privacybody2')}
</h3>
<b>
{t('privacybody3')}
</b>
<h1>  </h1>
<b>
{t('privacybody4')}
</b>

      </div>
    );
    
  }