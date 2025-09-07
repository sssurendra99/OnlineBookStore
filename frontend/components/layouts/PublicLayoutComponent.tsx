import React, { type FC } from 'react'
import HeaderComonent from '../ui-tools/HeaderComponent';
import FooterComponent from '../ui-tools/FooterComponent'

interface PublicLayoutProps {
    children: React.ReactNode;
}

const PublicLayoutComponent : FC<PublicLayoutProps> = ({ children }) => {
    return (
        <>
            <header className='w-fit p-14 m-auto'>
                <HeaderComonent />
            </header>
            <main>
                {children}
            </main>
            <footer className='bg-[#1c1e2f] text-white p-10 '>
                <FooterComponent />
            </footer>
        </>
    )
}

export default PublicLayoutComponent;