import Categories from "../components/categories-menu";
import { useTranslation } from 'react-i18next';

export default function Contacts() {
  const { t } = useTranslation();
    return (
      <div>
         <Categories/>
        <h1 style={{textAlign: "center"}}>{t('contact')}</h1>
        {/* rest of your contact page content */}
      
      </div>
    );
    
  }